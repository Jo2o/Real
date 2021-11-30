package functional.venkat.lambdadesign;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Asset {

    public enum AssetType { BOND, STOCK }

    private final AssetType assetType;
    private final int value;
}
