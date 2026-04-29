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

## Build
1. Open in Android Studio Hedgehog+.
2. Add `local.properties` values for API base URL/key.
3. Sync Gradle.
4. Run on emulator/device.

## Next Steps
- Implement full form validation and role-based admin screens.
- Wire file upload multipart flow to Apps Script + Drive.
- Add Room cache for richer offline-first behavior.
