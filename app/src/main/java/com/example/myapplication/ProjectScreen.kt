package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateProjectScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Handle back button click */ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Text(
                text = "Create Project",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(start = 2.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle project title change */ },
            label = { Text("Project title") },
            placeholder = { Text("Enter project title") },
            leadingIcon = { Icon(Icons.Default.Edit, contentDescription = "Project title icon") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle description change */ },
            label = { Text("Description") },
            placeholder = { Text("Enter project description") },
            leadingIcon = { Icon(Icons.Default.Info, contentDescription = "Description icon") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "10-10-2024",
            onValueChange = { /* Handle due date change */ },
            label = { Text("Due date") },
            leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = "Due date icon") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Participants",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Handle add participant */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add participant")
            }

            ParticipantChip(name = "Derat")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle create button click */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF37474F),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(2.dp)
        ) {
            Text(
                text = "Create",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
        }

    }
}

@Composable
fun ParticipantChip(name: String) {
    Box(
        modifier = Modifier
            .background(Color(0xFFCCFFCC), shape = RoundedCornerShape(50))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.derek_image),
                contentDescription = "Participant avatar",
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(text = name)

            IconButton(onClick = { /* Handle remove participant */ }) {
                Icon(Icons.Default.Close, contentDescription = "Remove participant", tint = Color.Black)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewCreateProjectScreen() {
    CreateProjectScreen()
}
