package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void set_for_one_day() {

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item[] expectedItems = new Item[]{
                new Item("+5 Dexterity Vest", 9, 19),
                new Item("Aged Brie", 1, 1),
                new Item("Elixir of the Mongoose", 4, 6),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                new Item("Conjured Mana Cake", 2, 5)};

        for (int i = 0; i < items.length; i++) {
            assertEquals(expectedItems[i].toString(), items[i].toString());
        }
    }

    @Test
    void set_for_two_days() {

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();

        Item[] expectedItems = new Item[]{
                new Item("+5 Dexterity Vest", 8, 18),
                new Item("Aged Brie", 0, 2),
                new Item("Elixir of the Mongoose", 3, 5),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 13, 22),
                new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
                new Item("Conjured Mana Cake", 1, 4)};

        for (int i = 0; i < items.length; i++) {
            assertEquals(expectedItems[i].toString(), items[i].toString());
        }
    }

    @Test
    void set_for_ten_days() {

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 10; i++) {
        app.updateQuality();
        }

        Item[] expectedItems = new Item[]{
                new Item("+5 Dexterity Vest", 0, 10),
                new Item("Aged Brie", -8, 18),
                new Item("Elixir of the Mongoose", -5, 0),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 35),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", -5, 0),
                new Item("Conjured Mana Cake", -7, 0)};

        for (int i = 0; i < items.length; i++) {
            assertEquals(expectedItems[i].toString(), items[i].toString());
        }
    }
}
