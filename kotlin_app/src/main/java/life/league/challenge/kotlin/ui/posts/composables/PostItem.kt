package life.league.challenge.kotlin.ui.posts.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import life.league.challenge.kotlin.model.Post
import life.league.challenge.kotlin.ui.composables.PrimaryText

@Composable
fun PostItem(post: Post) {
    val painter = rememberImagePainter("${post.imageUrl}")
    Column(modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .size(58.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.width(16.dp))
            PrimaryText(text = "${post.author}")
        }
        Spacer(modifier = Modifier.height(8.dp))
        PrimaryText(
            textAlign = TextAlign.Start,
            maxLines = 1, text = "${post.title}", textSize = MaterialTheme.typography.h6.fontSize, textStyle = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        PrimaryText(
            textAlign = TextAlign.Start,
            maxLines = 3,
            text = "${post.body}",
        )
    }
}
