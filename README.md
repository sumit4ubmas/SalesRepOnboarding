# Plum Sales Academy (Android + Google Sheets)

Native Android app for onboarding, training, certification, and controlled field-access for sales reps.

## Tech Stack
- Kotlin + Jetpack Compose + MVVM
- Retrofit API client to Google Apps Script Web App
- Google Sheets as data store
- Google Drive for files
- DataStore for local session persistence
- WorkManager for offline sync retries

## Implemented Project Structure
- `app/` Android app module
- `backend/Code.gs` Apps Script API gateway with required endpoints
- `docs/google_sheet_schema.md` spreadsheet setup instructions
- `seed/seed_data.csv` initial training module and quiz seed rows

## Main Flows Included
- Splash -> Login -> OTP -> Profile Setup -> Onboarding Checklist
- Document Upload
- Training Hub + Training Module detail
- Quiz + Certification Result (80% pass rule)
- Access Unlocked + Dashboard + Leads

## API Pattern
All requests are POST JSON:
```json
{ "apiKey": "...", "action": "loginUser", "payload": { } }
```
All responses:
```json
{ "status": "success|error", "message": "...", "data": {} }
```

## Certificate Format
- `PLUM-YYMMDD-ATTEMPT`
- Includes trainee name, score, attempt no, issued date, certificate ID.
- PDF generation approach: generate HTML template in Apps Script and export via Drive PDF blob URL.

## If You Don't Have Android Studio
You can still build and get an APK using command line + GitHub Actions.

### Option A: GitHub Actions (recommended)
1. Push this repo to GitHub.
2. Open **Actions** tab and run `Android CLI Build` workflow.
3. Download artifact `plum-sales-academy-debug-apk`.
4. Install APK on your Android device.

Workflow file: `.github/workflows/android-cli-build.yml`.

### Option B: Local command line
Prerequisites:
- JDK 17
- Android command-line tools + SDK packages (`platforms;android-34`, `build-tools;34.0.0`)
- `gradle` installed globally

Build command:
```bash
gradle :app:assembleDebug
```
APK output:
`app/build/outputs/apk/debug/`

## Google Sheets + Apps Script Setup
1. Create spreadsheet tabs as listed in `docs/google_sheet_schema.md`.
2. Paste `backend/Code.gs` into Google Apps Script.
3. Set `API_KEY` and deploy as Web App.
4. Point Android app API base URL to your Apps Script URL.

## Current Status
- Project is a functional scaffold of screens + architecture.
- Backend handlers in Apps Script are mocked starter implementations and should be connected to real Sheet CRUD for production.

## Next Steps
- Implement full validation and role-based admin screens.
- Wire file upload multipart flow to Apps Script + Drive.
- Add Room cache for richer offline-first behavior.
