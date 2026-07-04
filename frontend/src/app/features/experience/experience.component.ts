import { Component, signal, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '../../core/services/portfolio.service';
import { SectionHeaderComponent } from '../../shared/components/section-header/section-header.component';
import { InViewDirective } from '../../shared/directives/in-view.directive';

@Component({
  selector: 'app-experience',
  standalone: true,
  imports: [CommonModule, SectionHeaderComponent, InViewDirective],
  templateUrl: './experience.component.html',
  styleUrl: './experience.component.scss'
})
export class ExperienceComponent {
  private portfolioService = inject(PortfolioService);
  data = this.portfolioService.data;
  visible = signal(false);

  onInView(): void { this.visible.set(true); }
}
