package com.plum.salesacademy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plum.salesacademy.ui.screens.*

@Composable
fun PlumNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.Splash) {
        composable(Routes.Splash) { SplashScreen { navController.navigate(Routes.Login) } }
        composable(Routes.Login) { LoginScreen() }
        composable(Routes.Otp) { OtpScreen() }
        composable(Routes.Profile) { ProfileSetupScreen() }
        composable(Routes.Onboarding) { OnboardingChecklistScreen() }
        composable(Routes.Documents) { DocumentUploadScreen() }
        composable(Routes.TrainingHub) { TrainingHubScreen() }
        composable(Routes.Module) { TrainingModuleScreen() }
        composable(Routes.Quiz) { QuizScreen() }
        composable(Routes.Result) { CertificationResultScreen() }
        composable(Routes.Unlock) { AccessUnlockedScreen() }
        composable(Routes.Dashboard) { DashboardScreen() }
        composable(Routes.Leads) { LeadListScreen() }
    }
}
