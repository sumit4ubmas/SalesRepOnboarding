package com.plum.salesacademy.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable fun SplashScreen(onReady: () -> Unit) { SideEffectRun(onReady); CenteredTitle("Plum Sales Academy") }
@Composable fun LoginScreen() = FormScaffold("Login", listOf("Phone or Email", "Send OTP", "Admin Credentials"))
@Composable fun OtpScreen() = FormScaffold("OTP Verification", listOf("6-digit OTP", "Verify", "Resend OTP"))
@Composable fun ProfileSetupScreen() = FormScaffold("Profile Setup", listOf("Full Name", "Email", "Phone", "Territory", "Manager"))
@Composable fun OnboardingChecklistScreen() = ListScaffold("Onboarding Checklist", listOf("Profile Setup", "Driver License", "Insurance", "Bank Details", "Commission E-Sign", "Training", "Certification", "Access Unlock"))
@Composable fun DocumentUploadScreen() = FormScaffold("Document Upload", listOf("Camera / Files", "PDF/JPG/PNG", "10MB max", "Upload Status"))
@Composable fun TrainingHubScreen() = ListScaffold("Training Hub", listOf("Product Training", "D2D Masterclass", "AI Role Play", "Certification (Locked until complete)"))
@Composable fun TrainingModuleScreen() = ListScaffold("Training Module", listOf("Header", "Estimated Time", "Scripts", "Checklist", "Mark Complete"))
@Composable fun QuizScreen() = ListScaffold("Certification Quiz", listOf("Fetch questions from API", "One at a time", "80% pass required"))
@Composable fun CertificationResultScreen() = ListScaffold("Certification Result", listOf("Score", "Attempt", "Certificate ID", "Pass/Fail gating"))
@Composable fun AccessUnlockedScreen() = ListScaffold("Access Unlocked", listOf("Dashboard", "Leads", "Check-in", "Pitch", "Payment", "Contract"))
@Composable fun DashboardScreen() = ListScaffold("Dashboard", listOf("Leads Today", "Visits", "Deals Won", "Revenue", "Close Rate"))
@Composable fun LeadListScreen() = ListScaffold("Lead List", listOf("Filter by status", "Assigned leads", "Add lead if certified"))

@Composable private fun CenteredTitle(title: String) { Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text(title, style = MaterialTheme.typography.headlineSmall) } }
@Composable private fun FormScaffold(title: String, fields: List<String>) { Scaffold(topBar = { TopAppBar(title = { Text(title) }) }) { p -> LazyColumn(Modifier.padding(p).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) { items(fields.size) { OutlinedCard { Text(fields[it], Modifier.padding(16.dp)) } } } } }
@Composable private fun ListScaffold(title: String, items: List<String>) { Scaffold(topBar = { TopAppBar(title = { Text(title) }) }) { p -> LazyColumn(Modifier.padding(p).padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) { items(items.size) { AssistChip(onClick = {}, label = { Text(items[it]) }) } } } }
@Composable private fun SideEffectRun(action: () -> Unit) { androidx.compose.runtime.LaunchedEffect(Unit) { action() } }
