import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState


@Composable
fun CampusMapScreen() {
    val tumLocation = LatLng(-4.0435, 39.6682)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(tumLocation, 17f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = rememberMarkerState(position = tumLocation),
            title = "Technical University of Mombasa",
            snippet = "Main Campus"
        )
    }
}
