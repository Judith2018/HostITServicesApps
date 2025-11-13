# Host IT Services App

Host IT Services is an Android application prototype designed to provide users with a simple way to manage domains, hosting plans, support tickets, and shopping cart functionality. The app mirrors the team’s Figma design and focuses on clean navigation, branded UI, and responsive user interactions.

## Features

- **Dashboard**
  - Central hub with navigation to all major sections
  - Buttons for Domains, Hosting Plans, Support, and Cart

- **Domain Management**
  - Search for available domains
  - Initiate domain transfers
  - Feedback dialogs to confirm actions

- **Hosting Plans**
  - View Starter, Basic, Pro, and Business hosting packages
  - Tap a plan to add it to the cart

- **Support Tickets**
  - Submit new support tickets
  - Confirmation dialog shows ticket logged
  - Form clears for next ticket entry

- **Cart**
  - Displays selected hosting plans or domain actions
  - Back to Dashboard and Logout options

- **Logout**
  - Available on all screens
  - Confirmation dialog before logging out
  - Redirects to LoginActivity

## Tech Stack

- Language: Kotlin
- UI: XML layouts (pixel-perfect match to Figma prototype)
- Frameworks: AndroidX, AppCompat
- IDE: Android Studio

## Project Structure
app/src/main/java/com/example/hostitservices/ 
│ ├── DashboardActivity.kt 
├── DomainActivity.kt 
├── HostingPlansActivity.kt 
├── SupportActivity.kt 
├── CartActivity.kt 
└── LoginActivity.kt


Layouts are stored in `app/src/main/res/layout/`.

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/Judith2018/HostITServices.git
