import { Component, signal, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '../../core/services/portfolio.service';
import { SectionHeaderComponent } from '../../shared/components/section-header/section-header.component';
import { InViewDirective } from '../../shared/directives/in-view.directive';

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [CommonModule, SectionHeaderComponent, InViewDirective],
  templateUrl: './about.component.html',
  styleUrl: './about.component.scss'
})
export class AboutComponent {
  private portfolioService = inject(PortfolioService);
  data = this.portfolioService.data;
  visible = signal(false);
  activeCategory = signal<number>(1);

  onInView(): void {
    this.visible.set(true);
  }

  setCategory(order: number): void {
    this.activeCategory.set(order);
  }
}
