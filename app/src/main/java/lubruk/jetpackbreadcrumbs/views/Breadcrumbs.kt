package lubruk.jetpackbreadcrumbs.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <ItemType> Breadcrumbs(breadcrumbsController: BreadcrumbsController<ItemType>) {
    val lazyListState = rememberLazyListState()

    LazyRow(modifier = Modifier.fillMaxWidth(), state = lazyListState) {
        itemsIndexed(breadcrumbsController.getItems()) { index, item ->
            TextButton(onClick = { breadcrumbsController.onItemTap(index = index, item = item) }) {
                Text(item.toString())
            }
        }
    }
}

