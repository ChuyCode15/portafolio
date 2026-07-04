import { Component, signal, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PortfolioService } from '../../core/services/portfolio.service';
import { ApiService } from '../../core/services/api.service';
import { SectionHeaderComponent } from '../../shared/components/section-header/section-header.component';
import { InViewDirective } from '../../shared/directives/in-view.directive';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [CommonModule, FormsModule, SectionHeaderComponent, InViewDirective],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.scss'
})
export class ContactComponent {
  private portfolioService = inject(PortfolioService);
  private apiService = inject(ApiService);

  data = this.portfolioService.data;
  visible = signal(false);

  form = {
    name: '',
    email: '',
    subject: '',
    message: '',
  };

  status = signal<'idle' | 'sending' | 'success' | 'error'>('idle');
  errorMsg = signal('');

  onInView(): void { this.visible.set(true); }

  submitForm(): void {
    if (!this.form.name || !this.form.email || !this.form.subject || !this.form.message) return;

    this.status.set('sending');
    this.apiService.sendContact(this.form).subscribe({
      next: () => {
        this.status.set('success');
        this.form = { name: '', email: '', subject: '', message: '' };
      },
      error: () => {
        this.status.set('error');
        this.errorMsg.set(this.data()?.contact.form.errorMessage ?? 'Error al enviar');
      }
    });
  }
}
