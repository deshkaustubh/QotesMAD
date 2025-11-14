# QotesMAD

Minimal Jetpack Compose quotes demo (single module, in‑memory data, Material 3, Navigation Compose).

## Overview
Home: highlight + latest + categories + trending.
Explore: tabbed category filtering (All + each category, optional `?category=` param).
Saved: placeholder for future favorites.

## Features (Now / Next)
Now: Compose UI, Navigation, Category filter, Reusable quote & category cards.
Next: Favorites persistence, dark theme, network API, ViewModels + repository, share/like state.

## Tech Stack
Kotlin 2.0.21 • AGP 8.12.3 • Compose BOM 2024.09.00 • Material3 • Navigation 2.9.5 • Min SDK 26 / Target 36 • JVM 11.
No DI, no persistence, no networking yet.

## Architecture (YAML Diagram)
```yaml
app:
  navigation:
    start: home
    routes: [home, explore?category, saved]
  ui:
    screens:
      - Home
      - Explore
      - Saved (placeholder)
    components: [QuoteBanner, QuotesCard, ExploreQuotesCard, CategoryCard, SectionHeader]
  data:
    models: [Quote, QuoteCategory]
    source: InMemory(Quote.getQuotes)
  theme:
    material3: true
    typography: [Bold20, Medium16, Normal14, Normal12]
future_additions:
  - FavoritesPersistence
  - DarkTheme + DynamicColor
  - NetworkAPI + Pagination
  - ViewModels + RepositoryLayer
  - Tests + CI
```

## Structure
```text
app/
  MainActivity.kt
  AppNavGraph.kt
  QuotesScreenRoutes.kt
  data/ (Quote.kt, QuoteCategory.kt)
  view/components/ (cards, banner, headers)
  view/screens/ (Home, Explore, Saved)
  ui/theme/ (Color, Type, Theme)
```

## Build & Run
```bash
./gradlew assembleDebug
adb install -r app/build/outputs/apk/debug/app-debug.apk
```
Or run the app configuration in Android Studio.

## Screens (Summary)
| Screen | Notes |
|--------|-------|
| Home | Mixed vertical & horizontal lists (quotes + categories + trending) |
| Explore | ScrollableTabRow filters quotes; supports deep link category param |
| Saved | Placeholder |

## Data Model
`Quote(id, text, author, category, avatar)` from static list.  
`QuoteCategory` enum: displayName, icon, bgColor (+ helper lookup).

## Screenshots

<p align="center">
  <img src=![img.png](img.png) alt="Home screen showing latest, categories and trending quotes" width="360" />
  <img src=![img_1.png](img_1.png) alt="Explore screen filtered by Life category" width="360" />
</p>


Markdown table fallback (if HTML not desired):
```markdown
| Home | Explore |
|------|---------|
| ![Home screen showing latest, categories and trending quotes](docs/images/home-light.png) | ![Explore screen filtered by Life category](docs/images/explore-life-light.png) |
```

Optional dark theme pair (when added): duplicate with `-dark` suffix and show a second row.

## Images Guide
Put assets in `docs/images/`.
Pattern: `<screen>-<state>-<theme>.png` (e.g. `explore-life-light.png`).
Markdown: `![Explore Life tab](docs/images/explore-life-light.png)`
Side-by-side (HTML) for light/dark if needed.

## Roadmap (Condensed)
1. Favorites (Saved content)  
2. Dark & dynamic theme  
3. Network + repository  
4. ViewModels & UI state classes  
5. Share / like with real state  
6. Tests + CI + lint (ktlint/detekt)  

## Limitations
In-memory only • No dark theme • No persistence • No tests • Hard-coded strings/colors.

## License
Add a LICENSE file (MIT/Apache 2.0). Currently unlicensed placeholder.

---
Concise doc: expand in `/docs` only when complexity increases.
