import { Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import type { PortfolioData } from '../models/portfolio.models';

@Injectable({ providedIn: 'root' })
export class PortfolioService {
  private readonly _data = signal<PortfolioData | null>(null);

  readonly data = this._data.asReadonly();

  constructor(private http: HttpClient) {
    this.load();
  }

  private load(): void {
    this.http
      .get<PortfolioData>('/assets/portfolio.data.json')
      .pipe(tap(data => this._data.set(data)))
      .subscribe();
  }
}
