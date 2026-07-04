import { Component, inject, computed } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '@core/services/portfolio.service';
import { ParticlesComponent } from '@shared/components/particles/particles.component';
import { TypewriterComponent } from '@shared/components/typewriter/typewriter.component';
import { ButtonComponent } from '@shared/components/button/button.component';

@Component({
  selector: 'app-hero',
  standalone: true,
  imports: [CommonModule, ParticlesComponent, TypewriterComponent, ButtonComponent],
  templateUrl: './hero.component.html',
  styleUrl: './hero.component.scss',
})
export class HeroComponent {
  private portfolio = inject(PortfolioService);

  readonly personal = computed(() => this.portfolio.personal());
  readonly social   = computed(() => this.portfolio.social());
  readonly heroBg   = computed(() => this.portfolio.bgs()?.hero ?? '');
}
