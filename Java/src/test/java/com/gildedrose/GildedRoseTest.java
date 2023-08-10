package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void testApproval() {
        CombinationApprovals.verifyAllCombinations(
            this::callUpdateQuality,
            new String[]{"foo", "Sulfuras, Hand of Ragnaros", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert"},
            new Integer[]{0, -1, 13},
            new Integer[]{0, 1, 50, 49}
        );
    }

    private String callUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        return gildedRose.items[0].toString();
    }

}
