# Google Sheet Schema
Create one spreadsheet with tabs:
Users, OnboardingProgress, Documents, TrainingModules, ModuleProgress, QuizQuestions, QuizAttempts, Certificates, FieldActivity, Leads, UploadLogs.

Use exactly the columns provided in the requirement prompt.

## Setup
1. Create tabs with header row frozen.
2. Add data validation for Role (Sales Rep/Admin), Status (Active/Inactive), PassFail (Pass/Fail).
3. Protect admin-only columns (VerifiedBy, VerifiedAt, VerificationStatus).
4. Deploy Apps Script `backend/Code.gs` as web app and use URL in Android app config.
