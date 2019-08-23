package com.gildedrose;

public class SulfurusItem extends Item {
    public SulfurusItem(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    void updateItemQuality() {
    }
}
