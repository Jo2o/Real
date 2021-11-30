package functional.venkat.lambdadesign;

import static functional.venkat.lambdadesign.Asset.AssetType.BOND;
import static functional.venkat.lambdadesign.Asset.AssetType.STOCK;

import java.util.List;
import java.util.function.Predicate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SeparateConcern {


    public static void main(String[] args) {
        SeparateConcern separateConcern = new SeparateConcern();

        int totalAssetsValue = separateConcern.createAssets()
                .stream()
                .mapToInt(Asset::getValue)
                .sum();

        log.info("Total assets' value: {}", totalAssetsValue);

        /*
        * Remove: how to iterate, what to total, and how to total
        * To be more flexible - get total of BONDS vs STOCKS vs ALL
        * WILL CREATE METHOD THAT ACCEPTS FILTERING FUNCTION!
        */
//        ToIntFunction<Asset> stockValueExtractor = asset -> asset.getAssetType() == STOCK ? asset.getValue() : 0;
//        int total = separateConcern.createAssets()
//                .stream()
//                //.mapToInt(stockValueExtractor)
//                .sum();

        int total = separateConcern.calculateTotalAssetValue(separateConcern.createAssets(), asset -> asset.getAssetType() == STOCK);
        log.info("Total of {} is: {}", STOCK, total);
    }

    private int calculateTotalAssetValue(List<Asset> assets, Predicate<Asset> assetSelector) { // simple strategy patten
        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }


    private List<Asset> createAssets() {
        return List.of(
                new Asset(BOND, 1000),
                new Asset(BOND, 2000),
                new Asset(STOCK, 3000),
                new Asset(STOCK, 4000));
    }
}
