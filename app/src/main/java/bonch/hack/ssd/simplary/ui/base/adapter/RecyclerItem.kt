package bonch.hack.ssd.simplary.ui.base.adapter

interface RecyclerItem {
    val id: String?
    override fun equals(other: Any?): Boolean
}