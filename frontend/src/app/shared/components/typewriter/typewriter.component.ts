import { Component, OnInit, OnDestroy, input, signal } from '@angular/core';

@Component({
  selector: 'app-typewriter',
  standalone: true,
  templateUrl: './typewriter.component.html',
  styleUrl: './typewriter.component.scss'
})
export class TypewriterComponent implements OnInit, OnDestroy {
  texts = input<string[]>([]);
  speed = input<number>(55);
  deleteSpeed = input<number>(30);
  pauseAfter = input<number>(2000);

  displayed = signal('');
  private interval?: ReturnType<typeof setInterval>;
  private textIndex = 0;
  private charIndex = 0;
  private isDeleting = false;

  ngOnInit(): void {
    this.startTyping();
  }

  private startTyping(): void {
    const currentText = this.texts()[this.textIndex];

    this.interval = setInterval(() => {
      if (!this.isDeleting) {
        this.charIndex++;
        this.displayed.set(currentText.slice(0, this.charIndex));

        if (this.charIndex >= currentText.length) {
          this.isDeleting = true;
          clearInterval(this.interval);
          setTimeout(() => this.startDeleting(), this.pauseAfter());
        }
      }
    }, this.speed());
  }

  private startDeleting(): void {
    this.interval = setInterval(() => {
      this.charIndex--;
      this.displayed.set(this.texts()[this.textIndex].slice(0, this.charIndex));

      if (this.charIndex <= 0) {
        clearInterval(this.interval);
        this.isDeleting = false;
        this.textIndex = (this.textIndex + 1) % this.texts().length;
        setTimeout(() => this.startTyping(), 300);
      }
    }, this.deleteSpeed());
  }

  ngOnDestroy(): void {
    clearInterval(this.interval);
  }
}
