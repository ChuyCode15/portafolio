import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '../../core/services/portfolio.service';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule],
  template: `
    @if (data(); as d) {
      <footer class="footer">
        <span class="footer__logo">{{ d.personal.logoText }}</span>
        <span class="footer__copy">
          &copy; {{ year }} {{ d.personal.firstName }} {{ d.personal.lastName }}.
          Built with Angular + Spring Boot.
        </span>
        <div class="footer__socials">
          @for (s of d.social; track s.id) {
            <a [href]="s.url" target="_blank" rel="noopener noreferrer"
               class="footer__social-icon" [attr.aria-label]="s.label">
              <i [class]="s.icon"></i>
            </a>
          }
        </div>
      </footer>
    }
  `,
  styleUrl: './footer.component.scss'
})
export class FooterComponent {
  private portfolioService = inject(PortfolioService);
  data = this.portfolioService.data;
  year = new Date().getFullYear();
}
