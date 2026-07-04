import {
  Directive, ElementRef, OnInit, OnDestroy,
  output, input
} from '@angular/core';

@Directive({
  selector: '[appInView]',
  standalone: true
})
export class InViewDirective implements OnInit, OnDestroy {
  threshold = input<number>(0.15);
  inView = output<boolean>();

  private observer!: IntersectionObserver;
  private triggered = false;

  constructor(private el: ElementRef<HTMLElement>) {}

  ngOnInit(): void {
    this.observer = new IntersectionObserver(
      ([entry]) => {
        if (entry.isIntersecting && !this.triggered) {
          this.triggered = true;
          this.inView.emit(true);
        }
      },
      { threshold: this.threshold() }
    );
    this.observer.observe(this.el.nativeElement);
  }

  ngOnDestroy(): void {
    this.observer.disconnect();
  }
}
