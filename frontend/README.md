# Anglesvar Portfolio — Angular 21 + SCSS

A fully animated, responsive developer portfolio built with **Angular 21** using modern patterns: standalone components, signals, `@if`/`@for` control flow, and inject-based DI.

---

## 🚀 Quick Start

```bash
cd ng-portfolio
npm install
npm start          # dev server at http://localhost:4200
npm run build      # production build
```

---

## 📁 Project Structure

```
ng-portfolio/
├── angular.json                          # Angular CLI config (includePaths for SCSS)
├── tsconfig.json                         # TypeScript config with path aliases
├── src/
│   ├── main.ts                           # Bootstrap entry point
│   ├── index.html                        # Shell HTML
│   ├── assets/
│   │   └── portfolio.data.json           # ← EDIT THIS to update all content
│   ├── styles/
│   │   ├── main.scss                     # Global styles + resets
│   │   └── abstracts/
│   │       ├── _variables.scss           # Design tokens (colours, fonts, spacing)
│   │       ├── _mixins.scss              # Responsive breakpoint mixins
│   │       ├── _animations.scss          # @keyframes
│   │       └── _index.scss              # Barrel (@forward)
│   └── app/
│       ├── app.component.ts              # Root component (standalone)
│       ├── app.config.ts                 # Providers (HttpClient, Animations)
│       ├── core/
│       │   ├── models/
│       │   │   └── portfolio.models.ts   # TypeScript interfaces
│       │   └── services/
│       │       └── portfolio.service.ts  # Loads JSON, exposes Signal
│       ├── shared/
│       │   ├── components/
│       │   │   ├── button/               # Reusable Button component
│       │   │   ├── section-header/       # Label + title + divider
│       │   │   ├── typewriter/           # Animated typewriter
│       │   │   └── particles/            # Canvas particle network
│       │   └── directives/
│       │       └── in-view.directive.ts  # IntersectionObserver scroll trigger
│       ├── layout/
│       │   ├── navbar/                   # Fixed top nav with scroll detection
│       │   └── footer/                   # Bottom footer
│       └── features/
│           ├── home/                     # Hero section
│           ├── about/                    # About + skills + stats
│           ├── projects/                 # Project cards grid
│           └── contact/                  # Contact section
```

---

## ✏️ Updating Content

**One file to rule them all:** `src/assets/portfolio.data.json`

| What to change | Where in JSON |
|---|---|
| Name, email, phone | `personal` |
| Resume link | `personal.resumeLink` |
| Social links | `social[]` — uses Font Awesome 6 class names |
| About text | `about.description` |
| Skills list | `about.skills[]` |
| Stat cards | `about.stats[]` |
| Project cards | `projects.fallbackRepos[]` |
| Background images | `backgrounds.hero/about/projects/contact` |
| Language colours | `languageColors` |

---

## 🆚 Angular 21 vs React — Key Differences

| Concept | React (previous) | Angular 21 |
|---|---|---|
| **Data sharing** | `useContext()` + Provider | `Injectable` service + `inject()` |
| **Reactive state** | `useState` | `signal()` |
| **Loops in template** | `{array.map(...)}` | `@for (item of arr; track item.id)` |
| **Conditionals** | `{condition && <El />}` | `@if (condition)` |
| **Component inputs** | Props | `input()` / `input.required()` |
| **Component outputs** | Callback props | `output()` |
| **Side effects** | `useEffect` | `ngOnInit`, `ngAfterViewInit` |
| **HTTP** | `fetch` / axios | `HttpClient` via DI |
| **Styling** | CSS Modules (`.module.scss`) | Component-scoped SCSS (`styleUrl`) |
| **Directives** | Custom hooks | `@Directive` with `selector` |

---

## 🎨 Theming

Edit `src/styles/abstracts/_variables.scss`:
```scss
$color-accent:     #63E1BE;   // Change to rebrand the whole site
$color-bg-primary: #050814;
$font-mono:        'Space Mono', monospace;
$font-display:     'Syne', sans-serif;
```

The `angular.json` file has `stylePreprocessorOptions.includePaths: ["src"]` so every component SCSS can write:
```scss
@use 'styles/abstracts' as *;
```
