package functional.venkat.lambdadesign;

import java.util.List;

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

        /* Remove: how to iterate, what to total, and how to total */

    }


    private List<Asset> createAssets() {
        return List.of(
                new Asset(Asset.AssetType.BOND, 1000),
                new Asset(Asset.AssetType.BOND, 2000),
                new Asset(Asset.AssetType.STOCK, 3000),
                new Asset(Asset.AssetType.STOCK, 4000));
    }
}
