package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            doUpdateItemQuality(items[i]);
        }
    }

    private void doUpdateItemQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            doUpdateAgedBrieQuality(item);
        } else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            doUpdateBackstageQuality(item);
        } else if(item.name.equals("Sulfuras, Hand of Ragnaros")){
            doUpdateSulfurasQuality(item);
        } else if(item.name.equals("Conjured Mana Cake")) {
            doUpdateConjuredQuality(item);
        } else {
            doUpdateDefaultQuality(item);
        }

    }

    private static void doUpdateDefaultQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private static void doUpdateSulfurasQuality(Item item) {

    }

    private static void doUpdateBackstageQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private static void doUpdateAgedBrieQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private static void doUpdateConjuredQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality - 2;
        }

        item.quality = Math.max(item.quality, 0);
    }
}
