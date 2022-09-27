package jcw.MemberManagement.form;

public class MemberForm {
    private String name;
    /*createMemberForm.html의 <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
      부분에서 name = "name"과 매칭
     */

    public String getName() {
        return name;
    }

    public void setName(String name) { //html에서 입력받은 내용을 전달
        this.name = name;
    }
}