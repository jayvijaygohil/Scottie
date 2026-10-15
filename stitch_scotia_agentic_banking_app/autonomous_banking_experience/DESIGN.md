---
name: Autonomous Banking Experience
colors:
  surface: '#fbf9f8'
  surface-dim: '#dbdad9'
  surface-bright: '#fbf9f8'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f5f3f3'
  surface-container: '#efeded'
  surface-container-high: '#eae8e7'
  surface-container-highest: '#e4e2e2'
  on-surface: '#1b1c1c'
  on-surface-variant: '#5e3f3b'
  inverse-surface: '#303030'
  inverse-on-surface: '#f2f0f0'
  outline: '#936e69'
  outline-variant: '#e9bcb6'
  surface-tint: '#c0000f'
  primary: '#bf000f'
  on-primary: '#ffffff'
  primary-container: '#ec111a'
  on-primary-container: '#ffffff'
  inverse-primary: '#ffb4aa'
  secondary: '#5f5e5e'
  on-secondary: '#ffffff'
  secondary-container: '#e5e2e1'
  on-secondary-container: '#656464'
  tertiary: '#006c47'
  on-tertiary: '#ffffff'
  tertiary-container: '#03885b'
  on-tertiary-container: '#000703'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#ffdad5'
  primary-fixed-dim: '#ffb4aa'
  on-primary-fixed: '#410001'
  on-primary-fixed-variant: '#930008'
  secondary-fixed: '#e5e2e1'
  secondary-fixed-dim: '#c8c6c5'
  on-secondary-fixed: '#1c1b1b'
  on-secondary-fixed-variant: '#474646'
  tertiary-fixed: '#8df7c1'
  tertiary-fixed-dim: '#71dba6'
  on-tertiary-fixed: '#002113'
  on-tertiary-fixed-variant: '#005235'
  background: '#fbf9f8'
  on-background: '#1b1c1c'
  surface-variant: '#e4e2e2'
  scotia-red-deep: '#C70A12'
  scotia-red-subtle: '#FDE8E9'
  surface-canvas: '#F4F5F7'
  surface-card: '#FFFFFF'
  surface-charcoal: '#1E1E1E'
  interac-gold: '#FFA800'
  interac-gold-subtle: '#FFF5E0'
  status-success: '#00875A'
  status-success-subtle: '#E6F5F0'
  text-primary: '#121212'
  text-secondary: '#595959'
  text-tertiary: '#8C8C8C'
  border-subtle: '#E5E7EB'
  glow-brand-red: rgba(236, 17, 26, 0.15)
typography:
  headline-lg:
    fontFamily: Hanken Grotesk
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
  headline-lg-mobile:
    fontFamily: Hanken Grotesk
    fontSize: 26px
    fontWeight: '700'
    lineHeight: 34px
  headline-md:
    fontFamily: Hanken Grotesk
    fontSize: 22px
    fontWeight: '600'
    lineHeight: 28px
  headline-sm:
    fontFamily: Hanken Grotesk
    fontSize: 18px
    fontWeight: '600'
    lineHeight: 24px
  title-lg:
    fontFamily: Hanken Grotesk
    fontSize: 16px
    fontWeight: '600'
    lineHeight: 22px
  title-md:
    fontFamily: Hanken Grotesk
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
  body-lg:
    fontFamily: Hanken Grotesk
    fontSize: 15px
    fontWeight: '400'
    lineHeight: 22px
  body-md:
    fontFamily: Hanken Grotesk
    fontSize: 13px
    fontWeight: '400'
    lineHeight: 18px
  label-md:
    fontFamily: Hanken Grotesk
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
  label-mono:
    fontFamily: JetBrains Mono
    fontSize: 11px
    fontWeight: '500'
    lineHeight: 14px
  code-sm:
    fontFamily: JetBrains Mono
    fontSize: 12px
    fontWeight: '400'
    lineHeight: 16px
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  gutter: 1rem
  margin: 1rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2rem
---

## Brand & Style

The design system establishes an intelligent, institutional banking experience blending the precision of mobile fintech with conversational agent architecture (A2UI). Built for modern Android (Material 3 foundations adapted for high-trust retail banking), the interface balances rigorous fiscal security with accessible AI utility.

The aesthetic marries **Corporate / Modern** structure with **Ambient Tactile** details:
- **Tone & Mood:** Authoritative, responsive, hyper-legible, and secure. Interactions feel immediate and low-friction, reducing financial cognitive load through structured mini-apps and chat cards.
- **Visual Style:** Clean light-surface foundations elevated by rich neutral-dark contrast, generous 24px–32px corner radii, precision micro-borders, and deliberate accents of iconic red alongside transaction-grade status signals (Interac gold and verification emerald).
- **A2UI Context:** Chat interactions avoid wall-of-text responses, preferring structured micro-widgets (interactive transfer slips, balance sparklines, on-device model parameter controls, and download progress strips) designed specifically for one-handed thumb ergonomics.

## Colors

The palette grounds the product in institutional identity while enabling sharp distinction across banking data streams and developer-level AI settings:

- **Primary (`#EC111A`):** The definitive brand anchor. Deployed for high-value interactive calls to action, dynamic brand accents, primary model connection statuses, and focused thumb-bar triggers.
- **Secondary (`#121212`):** Grounded obsidian used for primary typography, dark-mode surfaces, system-level bottom sheets, and developer console code snippets.
- **Tertiary (`#00875A`):** Trust and execution emerald. Used for completed e-Transfers, cleared transactions, verified cryptographic signatures, and online local weights.
- **Neutral (`#595959`):** Slate gray governing metadata, secondary transaction captions, inactive control labels, and subtle card delimiters.
- **Accent Tokens:** `interac-gold` (`#FFA800`) is reserved strictly for Interac e-Transfer operational context cards, pending authorizations, and dual-party verification queues.

Color usage adheres to strict hierarchy: interactive surfaces are driven by clean `#FFFFFF` against `#F4F5F7` backdrops, keeping pure black and red restrained to high-intent actions and visual anchors.

## Typography

Typography prioritizes tabular clarity and instant scanability. **Hanken Grotesk** serves as the primary family, combining European grotesque rhythm with the geometry required for high-density Android interfaces.

- **Headlines & Values:** Balances and account summaries utilize `headline-lg-mobile` with tabular figure styling to prevent layout shifts during live streaming balance feeds.
- **Agent Interactivity:** A2UI card headers utilize `title-md` and `headline-sm` with tight vertical metrics, maintaining compact vertical footprints within scrollable chat flows.
- **Model / System Specs:** Model runtime states, API latency counters (`ms`), quantization parameters (e.g., `q4_k_m`), and token-per-second outputs rely on **JetBrains Mono** to distinguish technical runtime status from consumer financial balances.

## Layout & Spacing

The layout model is anchored strictly to an 8-point system (with a secondary 4-point micro-scale for badges, toggles, and chips). 

- **Thumb Zone Architecture:** All primary banking execution paths (Confirm Transfer, Download Weights, Execute Payment) live within the lower 42% of the viewport. Chat viewports stream from the center down, nesting interactive cards directly above the sticky input dock.
- **Mobile Grid:** Single fluid column with `margin: 1rem` (16px) gutter and margin boundaries. Interactive chat cards span `100%` of the available width minus margins, avoiding asymmetric horizontal speech bubbles for complex financial data.
- **Tablet / Split View (600dp+):** The layout converts to a dual-pane canvas: A2UI chat and interactive cards occupy the left 60% fluid container, while transaction history and AI settings (weights management, temperature sliders, API host toggles) dock permanently on the right 40%.

## Elevation & Depth

Visual hierarchy uses a refined hybrid of tonal layer steps, hair-thin surface lines, and subtle chromatic ambient lighting:

- **Level 0 (Canvas):** Pure `#F4F5F7` background providing neutral contrast for foreground containers.
- **Level 1 (Default Cards & A2UI Bubbles):** Crisp `#FFFFFF` surface accompanied by a 1px solid border (`border-subtle: #E5E7EB`) and an ultra-soft ambient shadow: `0px 2px 8px rgba(0, 0, 0, 0.04)`.
- **Level 2 (Active Cards & Floating Widgets):** Elevates interactive A2UI forms (e.g., pending e-Transfer approvals). Uses `0px 8px 24px rgba(0, 0, 0, 0.08)` coupled with an intentional 1px inset highlight (`rgba(255, 255, 255, 0.8)`).
- **Brand Glow Highlight:** Selected model cards, active download toggles, or primary action focus rings inherit a soft, chromatic brand glow: `0px 0px 16px rgba(236, 17, 26, 0.14)`.
- **Level 3 (Sticky Bottom Sheet / Input Rail):** High-density `#FFFFFF` resting atop canvas with a directional vertical blur: `0px -4px 20px rgba(0, 0, 0, 0.06)`.

## Shapes

The design system incorporates modern Material 3 radii while retaining architectural structure:

- **Base Components (`rounded-md`, 8px):** Checkboxes, segmented buttons, sliders, input fields, and inline code badges.
- **Interactive Controls (`rounded-lg`, 16px):** Action buttons, balance chips, secondary status badges, and transaction line items.
- **Containers & A2UI Cards (`rounded-xl` / `rounded-2xl`, 24px):** All dynamic chat cards, transfer slips, model download drawers, and API parameter containers.
- **Floating Controls (Pill / Fully Rounded):** Quick prompt suggestions, status indicators, and sticky CTA thumb pills.

## Components

### Buttons & Primary Triggers
- **Primary Action Pill:** Solid `#EC111A` background, pure white text, 48px standard touch target height, `rounded-lg` (16px). When pressed: scales down to `0.98` with state layer `rgba(0, 0, 0, 0.1)`.
- **Secondary Action:** Ghost container with 1px border (`#E5E7EB`), text in `#121212`, hovering into subtle red tint (`#FDE8E9`).
- **Destructive/Cancel:** Inset muted tone with `#C70A12` text.

### Tactile Balance & Quick-Action Chips
- Pill-shaped (`rounded-full`), height 36px, horizontal padding `space-md`.
- Background `#FFFFFF` with 1px border `#E5E7EB`. Contains a small currency symbol or status dot, followed by formatted numerical values in `Hanken Grotesk` (SemiBold).
- Active/Selected state: border switches to `#EC111A` with a soft inner tint (`#FDE8E9`).

### A2UI Chat Cards
- **Transaction Filter Card:** White card with 24px radius. Displays a segmented chip filter at the top (All, Sent, Received, Bills), followed by dense list rows separated by 0.5px hairline dividers.
- **Interac e-Transfer Form Card:** Top decorative band featuring `interac-gold` (`#FFA800`) accent strip (3px). Features structured fields for Recipient, Account Selector, Amount with auto-formatting, and a prominent bottom confirmation button.
- **Balance Breakdown Card:** Embedded micro-chart or segment bar visualization displaying Checking, Savings, and Credit lines, using tertiary and primary indicators.

### Model & API Settings Controls
- **Model Download Card:** Surface `#FFFFFF` with rounded-2xl corners. Contains model name (e.g., `Llama-3-8B-Instruct-Q4`), parameter chip (`JetBrains Mono`), on-device storage indicator (`4.3 GB`), and a responsive progress bar.
- **Progress Bar:** 6px track height, fully rounded. Background `#E5E7EB`, active track `#EC111A` (or `#00875A` when completed).
- **API Toggle Switch:** Material-style track: 52px width, 32px height. When enabled: thumb shifts right with `#EC111A` background fill and light tactile feedback.
- **Parameter Sliders (Temperature, Top-P, Context Size):** Custom discrete track with numeric readout pinned to the right using `label-mono`.

### Input Fields & Search Bars
- Background `#FFFFFF` with `#F4F5F7` fill in neutral states. 48px height, `rounded-md` (8px to 12px), 1px border `#E5E7EB`.
- Focused state: 2px border `#EC111A` accompanied by the `glow-brand-red` ambient shadow. Text aligns with `body-lg`.