package collections;

import java.util.List; import java.util.ArrayList; import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
    private static final String[] colors = { "MAGENTA", "RED", "WHITE", "BLUE", "CYAN" }; private static final String[] removeColors = { "RED", "WHITE", "BLUE" };
    // cria um ArrayList, adiciona cores e manipula
    public CollectionTest() { List< String > list = new ArrayList< String >(); List< String > removeList = new ArrayList< String >();
    // adiciona elementos a lista
    for ( String color : colors ) list.add( color );
    // adiciona elementos a lista
    for ( String color : removeColors )
    removeList.add( color );