<h1 align="center">JU CSE Routinery</h1>

<p align="center">
  An Android app for viewing and managing class routines in the Department of CSE, Jahangirnagar University.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=flat-square&logo=android&logoColor=white" alt="Android">
  <img src="https://img.shields.io/badge/Language-Java-E76F00?style=flat-square&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Database-SQLite-003B57?style=flat-square&logo=sqlite&logoColor=white" alt="SQLite">
  <img src="https://img.shields.io/badge/Min%20SDK-24-0E1420?style=flat-square" alt="Min SDK 24">
</p>

---

### About

Class routines in the department were shared as static files, which made it hard for students to find their schedule for the day or notice changes. JU CSE Routinery puts the routine in one app: students can check their daily and full routines by batch, and admins can add or update classes directly.

---

### Features

- **Separate admin and student login**, using a tabbed login screen
- **Daily routine**: see today's classes at a glance
- **Full routine by year and semester** (for example, 1st, 2nd, and 3rd year)
- **Batch routine view** for checking a specific batch's schedule
- **Admin tools** to add, update, and manage routine entries
- **Reminder notifications** for classes, using Android alarms
- **Local storage with SQLite**, so routines are available offline

---

### Screenshots

<!-- Add screenshots here, e.g.: -->
<!-- <img src="screenshots/login.png" width="200"> <img src="screenshots/daily.png" width="200"> -->

---

### Tech

`Java` `Android SDK` `SQLite` `RecyclerView` `Material Components` `AlarmManager` `Notifications`

---

### Getting started

1. Clone the repository:
   ```bash
   git clone https://github.com/nn-fiha/JU-CSE-ROUTINARY.git
   ```
2. Open the project in **Android Studio**.
3. Let Gradle sync, then run the app on an emulator or a device with **Android 7.0 (API 24) or higher**.

---

### Project structure
