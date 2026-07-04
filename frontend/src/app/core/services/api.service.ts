import { Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import type {
  ContactRequest,
  ContactResponse,
  ApiProfile,
  ApiProjectResponse,
  SkillCategory,
  Experience,
} from '../models/portfolio.models';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private readonly api = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  getProfile(): Observable<ApiProfile> {
    return this.http.get<ApiProfile>(`${this.api}/profile`);
  }

  getProjects(page = 0, size = 10): Observable<ApiProjectResponse> {
    return this.http.get<ApiProjectResponse>(`${this.api}/projects?page=${page}&size=${size}`);
  }

  getSkills(): Observable<SkillCategory[]> {
    return this.http.get<SkillCategory[]>(`${this.api}/skills`);
  }

  getExperience(): Observable<Experience[]> {
    return this.http.get<Experience[]>(`${this.api}/experience`);
  }

  sendContact(data: ContactRequest): Observable<ContactResponse> {
    return this.http.post<ContactResponse>(`${this.api}/contact`, data);
  }
}
