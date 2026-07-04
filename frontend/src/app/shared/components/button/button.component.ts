import { Component, input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-button',
  standalone: true,
  imports: [CommonModule],
  template: `
    <a
      [href]="href()"
      [target]="target()"
      [rel]="rel()"
      [class]="'btn btn--' + variant()"
    >
      <ng-content />
    </a>
  `,
  styleUrl: './button.component.scss'
})
export class ButtonComponent {
  href   = input.required<string>();
  variant = input<'primary' | 'outline'>('primary');
  target  = input<string>('_self');
  rel     = input<string>('');
}
