package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun CreateTaskScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        // Back Button and Title
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Handle*/ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Create Task",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Task Title Field
        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle  */ },
            label = { Text("Task title") },
            placeholder = { Text("Enter task title") },
            leadingIcon = { Icon(Icons.Default.Edit, contentDescription = "Task title icon") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Description Field
        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle  */ },
            label = { Text("Description") },
            placeholder = { Text("Enter task description") },
            leadingIcon = { Icon(Icons.Default.Info, contentDescription = "Description icon") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Start Date Field
        OutlinedTextField(
            value = "10-10-2024",
            onValueChange = { /* Handle  */ },
            label = { Text("Start date") },
            leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = "Start date icon") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )

        Spacer(modifier = Modifier.height(8.dp))

        // End Date Field
        OutlinedTextField(
            value = "20-10-2024",
            onValueChange = { /* Handle */ },
            label = { Text("End date") },
            leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = "End date icon") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Priority Section
        Text(
            text = "Priority",
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PriorityButton("Low", Color.Gray)
            PriorityButton("Medium", Color.Gray)
            PriorityButton("High", Color.Black)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Assign to Section
        Text(
            text = "Assign to",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        // Participant Chip
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ParticipantChip(name = "Derat")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Create Button
        Button(
            onClick = { /* Handle create button click */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(2.dp)
        ) {
            Text(text = "Create", color = Color.White)
        }
    }
}

@Composable
fun PriorityButton(text: String, color: Color) {
    Button(
        onClick = { /* Handle click */ },
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier
            .height(48.dp)
            .clip(RoundedCornerShape(4.dp)),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(text = text, color = Color.White)
    }
}

@Composable
fun ParticipantChip(name: String) {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp))
            .background(Color(0xFFCCFFCC), shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.derat),
                contentDescription = "Participant avatar",
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = name)

            IconButton(onClick = { /* Handle remove participant */ }) {
                Icon(Icons.Default.Close, contentDescription = "Remove participant", tint = Color.Black)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCreateTaskScreen() {
    CreateTaskScreen()
}

