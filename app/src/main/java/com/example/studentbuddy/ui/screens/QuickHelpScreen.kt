import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun QuickHelpScreen(navController: NavController,innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp, top = 30.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Help Icon",
                tint = Color(0xFFF4A300) // TUM deep blue
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Quick Help",
                style = MaterialTheme.typography.headlineMedium
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "📞 Contact Support",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFFF4A300)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text("Phone: +254 712 345 678", fontSize = 17.sp)
        Text("Email: support@campusbuddy.ac.ke", fontSize = 17.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "📌 Quick Tips",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFFF4A300)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text("• Check your timetable regularly for updates.",fontSize = 17.sp)
        Text("• Use the Lost & Found section for missing items.",fontSize = 17.sp)
        Text("• Ask for help from mentors or the support team.",fontSize = 17.sp)

        Spacer(modifier = Modifier.height(180.dp))


        Text(
                    text = "You’ve got this! Take it one step at a time, and don’t hesitate to ask for help whenever you need it.",
                    fontSize = 15.sp,
                    fontWeight = Bold,
                    color = Color(0xFFF4A300),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth() // so the centering works properly
        )

    }
}
