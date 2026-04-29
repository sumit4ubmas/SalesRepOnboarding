const API_KEY = 'REPLACE_WITH_SECRET';

function doPost(e) {
  try {
    const body = JSON.parse(e.postData.contents || '{}');
    if (body.apiKey !== API_KEY) return jsonError('Invalid API key');
    const action = body.action;
    const payload = body.payload || {};
    const handlers = {
      loginUser, verifyOtp, getUserProfile, saveUserProfile, uploadDocumentMetadata,
      getTrainingModules, saveModuleProgress, getQuizQuestions, submitQuizAttempt,
      createCertificate, getDashboardData, getLeads, createLead, updateLead,
      saveCheckIn, saveFieldActivity, adminVerifyDocument
    };
    if (!handlers[action]) return jsonError('Unknown action');
    return jsonSuccess('OK', handlers[action](payload));
  } catch (err) {
    return jsonError(err.message);
  }
}

function loginUser({identifier, pin}) { return { token: Utilities.getUuid(), identifier, otpRequired: true }; }
function verifyOtp({identifier, otp}) { return { userId: 'U001', identifier, role: 'SalesRep', certifiedStatus: 'No', otpValid: otp === '123456' }; }
function getUserProfile({userId}) { return { userId }; }
function saveUserProfile(payload) { return { saved: true, ...payload }; }
function uploadDocumentMetadata(payload) { return { saved: true, ...payload }; }
function getTrainingModules({trainingType}) { return { trainingType }; }
function saveModuleProgress(payload) { return { saved: true, ...payload }; }
function getQuizQuestions({trainingType}) { return { trainingType, questions: [] }; }
function submitQuizAttempt(payload) { return { pass: payload.percentScore >= 80, ...payload }; }
function createCertificate(payload) { return { certificateId: payload.certificateId }; }
function getDashboardData({userId}) { return { userId, leadsToday: 0, visitsDone: 0, dealsWon: 0 }; }
function getLeads({userId}) { return { userId, leads: [] }; }
function createLead(payload) { return { leadId: Utilities.getUuid(), ...payload }; }
function updateLead(payload) { return { updated: true, ...payload }; }
function saveCheckIn(payload) { return { checkInSaved: true, ...payload }; }
function saveFieldActivity(payload) { return { activitySaved: true, ...payload }; }
function adminVerifyDocument(payload) { return { verified: true, ...payload }; }

function jsonSuccess(message, data) { return ContentService.createTextOutput(JSON.stringify({status:'success', message, data})).setMimeType(ContentService.MimeType.JSON); }
function jsonError(message) { return ContentService.createTextOutput(JSON.stringify({status:'error', message, data:{}})).setMimeType(ContentService.MimeType.JSON); }
