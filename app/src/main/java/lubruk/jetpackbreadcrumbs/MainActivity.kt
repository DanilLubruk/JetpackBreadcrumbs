package lubruk.jetpackbreadcrumbs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import lubruk.jetpackbreadcrumbs.views.BreadcrumbsController.Companion.rememberBreadcrumbsState


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val breadcrumbsController = rememberBreadcrumbsState<String>(
                initialItems = ArrayList(
                    listOf(
                        "Item1",
                        "Item2",
                        "Item3",
                    )
                )


            )
        }
    }
}