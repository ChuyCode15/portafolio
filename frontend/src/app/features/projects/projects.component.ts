import { Component, signal, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '../../core/services/portfolio.service';
import { SectionHeaderComponent } from '../../shared/components/section-header/section-header.component';
import { ButtonComponent } from '../../shared/components/button/button.component';
import { InViewDirective } from '../../shared/directives/in-view.directive';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [CommonModule, SectionHeaderComponent, ButtonComponent, InViewDirective],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.scss'
})
export class ProjectsComponent {
  private portfolioService = inject(PortfolioService);
  data = this.portfolioService.data;
  visible = signal(false);
  expandedId = signal<number | null>(null);

  onInView(): void { this.visible.set(true); }

  toggleExpand(id: number): void {
    this.expandedId.update(current => current === id ? null : id);
  }
}
