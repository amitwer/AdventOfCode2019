package day3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class WireParser {
    private final Iterator<WireToken> tokenIterator;

    public WireParser(String wireInput) {
        String[] parts = wireInput.split(",");
        List<WireToken> tokens = Arrays.stream(parts).map(WireToken::new).collect(Collectors.toList());
        this.tokenIterator = tokens.iterator();
    }

    public boolean hasNextToken() {
        return tokenIterator.hasNext();
    }

    public WireToken next() {
        return tokenIterator.next();
    }
}
