import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun QuickHelpScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Help Icon",
                tint = Color(0xFF005BAC) // TUM deep blue
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Quick Help",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Text(
            text = "📞 Contact Support",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF005BAC)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text("Phone: +254 712 345 678")
        Text("Email: support@campusbuddy.ac.ke")

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "📌 Quick Tips",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF005BAC)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text("• Check your timetable regularly for updates.")
        Text("• Use the Lost & Found section for missing items.")
        Text("• Ask for help from mentors or the support team.")

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* Open support chat or email */ },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFA500), // TUM orange
                contentColor = Color.White
            )
        ) {
            Text("Talk to Support")
        }
    }
}
