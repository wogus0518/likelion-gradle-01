package com.line.parser;

import com.line.LineReaderContext;
import com.line.domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class HospitalParserTest {
//    String line1 = "\"A1120837\",\"서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)\",\"C\",\"의원\",\"G099\",\"응급의료기관 이외\",\"2\",\"외과: 상시진료 내과는 당분간 휴진\",\"서울시 송파구 문정동 장지동 법조단지 위례 가락동 가락시장역 위치 삼성서울병원 외래교수 출신 구강외과 전문의 진료 진료과목 - 임플란트 치조골 뼈이식 수술 매복 사랑니 발치 턱관절 악관절 질환의 치료 교정 치료 및 기타 보존 보철(크라운 브릿지 인레이) 신경치료\",\"방이역 1번출구 바로옆 굿모닝 신한증권 뒷건물\",\"가산기대찬의원\",\"02-6267-2580\",\"02-920-5374\",\"1930\",\"1930\",\"1930\",\"1930\",\"1930\",\"1500\",\"1500\",\"1500\",\"0900\",\"0900\",\"0900\",\"0900\",\"0900\",\"0900\",\"1000\",\"1000\",\"085\",\"11\",\"126.88412249700781\",\"37.4803938036867\",\"2022-04-07 14:55:00.0\"";
    LineReaderContext<Hospital> reader;
    String filename = "C:\\Users\\wogus\\Downloads\\서울시 병의원 위치 정보.csv";

    @BeforeEach
    void beforEach() {
        reader = new LineReaderContext<Hospital>(new HospitalParser());
    }

    @Test
    @DisplayName("ID가 파싱이 잘 되는지")
    void id() throws IOException {
        List<Hospital> hospitals = reader.readLines(filename);
        Assertions.assertEquals("A1120837", hospitals.get(0).getId());
    }

    @Test
    @DisplayName("Address가 파싱이 잘 되는지")
    void address() throws IOException {
        List<Hospital> hospitals = reader.readLines(filename);
        Assertions.assertEquals("서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)", hospitals.get(0).getAddress());
    }

    @Test
    @DisplayName("District가 파싱이 잘 되는지")
    void district() throws IOException {
        List<Hospital> hospitals = reader.readLines(filename);
        Assertions.assertEquals("서울특별시 금천구", hospitals.get(0).getDistrict());
    }

    @Test
    @DisplayName("Category가 파싱이 잘 되는지")
    void category() throws IOException {
        List<Hospital> hospitals = reader.readLines(filename);
        Assertions.assertEquals("C", hospitals.get(0).getCategory());
    }

    @Test
    @DisplayName("EmergencyRoom이 파싱이 잘 되는지")
    void emergencyRoom() throws IOException {
        List<Hospital> hospitals = reader.readLines(filename);
        Assertions.assertEquals(2, hospitals.get(0).getEmergencyRoom());
    }

    @Test
    @DisplayName("Name 이 파싱이 잘 되는지")
    void name() throws IOException {
        List<Hospital> hospitals = reader.readLines(filename);
        Assertions.assertEquals("가산기대찬의원", hospitals.get(0).getName());
    }

    @Test
    @DisplayName("Subdivision 이 파싱이 잘 되는지")
    void subdivision() throws IOException {
        List<Hospital> hospitals = reader.readLines(filename);
        Assertions.assertEquals("치과", hospitals.get(3).getSubdivision());
    }

    @Test
    @DisplayName("SQL문이 잘 출력 되는지 - subdivision 없을 때")
    void sqlNoSubdivision() throws IOException {
        List<Hospital> hospitals = reader.readLines(filename);
        Assertions.assertEquals("INSERT INTO `likelion-db`.`seoul_hospital`(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`) " +
                        "VALUES ('A1120837','서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)','서울특별시 금천구','C','2','가산기대찬의원',null);",
                hospitals.get(0).getSQL());
    }

    @Test
    @DisplayName("SQL문이 잘 출력 되는지 - subdivision 있을 때")
    void sqlExistSubdivision() throws IOException {
        List<Hospital> hospitals = reader.readLines(filename);
        System.out.println(hospitals.get(3).getSQL());
        Assertions.assertEquals("INSERT INTO `likelion-db`.`seoul_hospital`(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`) " +
                "VALUES ('A1117873','서울특별시 관악구 신원로 38 5층 (신림동 청암빌딩)','서울특별시 관악구','N','2','가로수치과의원','치과');",
                hospitals.get(3).getSQL());
    }

    @Test
    @DisplayName("SQL문 전부 다 출력")
    void printAll() throws IOException {
        List<Hospital> hospitals = reader.readLines(filename);
        for (int i = 0; i < hospitals.size(); i++) {
            String query = hospitals.get(i).getSQL();
            System.out.println(query);
        }
    }
}