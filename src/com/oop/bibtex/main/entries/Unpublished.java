package com.oop.bibtex.main.entries;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.Entry;
import com.oop.bibtex.main.visitors.IFileVisitor;
import java.util.Map;
import static com.oop.bibtex.main.Attributes.*;

public class Unpublished extends Entry {

    public static final Attributes[] requiredFields = {AUTHOR, TITLE, NOTE};
    public static final Attributes[] optionalFields = {MONTH, YEAR, KEY};

    public Unpublished(Map<Attributes, String> records, String key) {
        super(records, key);
    }

    @Override
    public void accept(IFileVisitor visitor) {
        visitor.visit(this);
    }
}
