import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '../../core/services/portfolio.service';
import { ParticlesComponent } from '../../shared/components/particles/particles.component';
import { TypewriterComponent } from '../../shared/components/typewriter/typewriter.component';
import { ButtonComponent } from '../../shared/components/button/button.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, ParticlesComponent, TypewriterComponent, ButtonComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  private portfolioService = inject(PortfolioService);
  data = this.portfolioService.data;
}
