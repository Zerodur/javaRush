package com.javarush.test.level21.lesson08.task02;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
Метод main изменять нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", null);
        Tree clone = null;
        clone = tree.clone();

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);

}

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        public Tree clone(){
            String[] branchClone = null;
            if (!(getBranches() == null))
            {
                if (this.branches.length > 0)
                {
                    branchClone = new String[this.branches.length];
                    for (int i = 0; i < this.branches.length; i++)
                    {
                        branchClone[i] = this.branches[i];
                    }
                }
            }
            Tree theClone = new Tree(getName(), branchClone);
            return theClone;
        }
    }
}
