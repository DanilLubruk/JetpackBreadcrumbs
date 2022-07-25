package lubruk.jetpackbreadcrumbs.views

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable

class BreadcrumbsController<ItemType> private constructor(
    initialItems: ArrayList<ItemType> = ArrayList(),
    private val onItemTap: (index: Int, item: ItemType) -> Unit = { index, item -> }
) {
    private val items: ArrayList<ItemType> = initialItems

    fun onItemTap(index: Int, item: ItemType) {
        onItemTap(index, item)
    }

    fun getItems() = items.toList()

    fun pushItem(item: ItemType) = items.add(item)
    fun popItem(): ItemType? = try {
        items.removeLast()
    } catch (exception: Exception) {
        null
    }

    private fun toBundle() = Bundle()

    companion object {
        @Composable
        fun <ItemType> rememberBreadcrumbsState(
            initialItems: ArrayList<ItemType> = ArrayList(),
        ): BreadcrumbsController<ItemType> {
            return rememberSaveable(saver = getSaver()) {
                BreadcrumbsController(initialItems = initialItems)
            }
        }

        private fun <ItemType> getSaver() = Saver<BreadcrumbsController<ItemType>, Bundle>(
            save = { it.toBundle() },
            restore = { fromBundle(it) }
        )

        private fun <ItemType> fromBundle(bundle: Bundle): BreadcrumbsController<ItemType> =
            BreadcrumbsController()
    }
}