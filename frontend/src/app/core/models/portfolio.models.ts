export interface SocialLink {
  id: number;
  icon: string;
  url: string;
  label: string;
}

export interface PersonalData {
  firstName: string;
  middleName: string;
  lastName: string;
  devDesc: string;
  logoText: string;
  resumeLink: string;
  mobileNumber: string;
  emailId: string;
  location: string;
}

export interface StatItem {
  value: string;
  label: string;
}

export interface SkillItem {
  name: string;
  icon: string;
  color: string;
  level: number;
}

export interface SkillCategory {
  category: string;
  categoryOrder: number;
  items: SkillItem[];
}

export interface HeroData {
  greeting: string;
  typewriterTexts: string[];
}

export interface AboutData {
  heading: string;
  subLabel: string;
  description: string;
  stats: StatItem[];
}

export interface ProjectMetric {
  label: string;
  value: string;
}

export interface Project {
  id: number;
  title: string;
  shortDescription: string;
  fullDescription: string;
  technologies: string[];
  category: string;
  featured: boolean;
  githubUrl: string;
  demoUrl: string;
  imageUrl: string;
  metrics: ProjectMetric[];
  highlights: string[];
}

export interface ProjectsData {
  heading: string;
  subLabel: string;
  displayCount: number;
  projects: Project[];
}

export interface Achievement {
  description: string;
}

export interface Experience {
  id: number;
  company: string;
  role: string;
  location: string;
  startDate: string;
  endDate: string | null;
  current: boolean;
  description: string;
  achievements: string[];
  technologies: string[];
}

export interface ContactFormData {
  namePlaceholder: string;
  emailPlaceholder: string;
  subjectPlaceholder: string;
  messagePlaceholder: string;
  sendText: string;
  sendingText: string;
  successMessage: string;
  errorMessage: string;
}

export interface ContactData {
  heading: string;
  subLabel: string;
  tagline: string;
  form: ContactFormData;
}

export interface NavigationData {
  links: string[];
  scrollThreshold: number;
}

export interface BackgroundData {
  hero: string;
  about: string;
  projects: string;
  contact: string;
}

export interface PortfolioData {
  personal: PersonalData;
  social: SocialLink[];
  hero: HeroData;
  about: AboutData;
  skills: SkillCategory[];
  projects: ProjectsData;
  experience: Experience[];
  contact: ContactData;
  navigation: NavigationData;
  backgrounds: BackgroundData;
  languageColors: Record<string, string>;
}

export interface ContactRequest {
  name: string;
  email: string;
  subject: string;
  message: string;
  phone?: string;
}

export interface ContactResponse {
  success: boolean;
  message: string;
  timestamp: string;
  messageId: string;
}

export interface ApiProfile {
  firstName: string;
  lastName: string;
  title: string;
  subtitle: string;
  summary: string;
  email: string;
  phone: string;
  location: string;
  photoUrl: string;
  resumeUrl: string;
  availableFor: string;
  socialLinks: SocialLink[];
}

export interface ApiProjectResponse {
  content: Project[];
  page: number;
  size: number;
  totalElements: number;
  totalPages: number;
  last: boolean;
}
