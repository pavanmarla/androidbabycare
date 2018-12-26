package com.anu.androidbabycare.model;

/**
 * Created by hp on 12/25/2018.
 */

public class BabyVaccine {


        private Integer id;

        private String name;

        private BabyDetails baby;

        private Integer age;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BabyDetails getBaby() {
            return baby;
        }

        public void setBaby(BabyDetails baby) {
            this.baby = baby;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }


}
