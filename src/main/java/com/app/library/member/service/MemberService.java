//member service
package com.app.library.member.service;

import com.app.library.member.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Service
public class MemberService{

    private List<Member> members = new ArrayList<>();

    public List<Member> getAllmembers(){
        return members;
    }

    public Optional<Member> getmemberById(Long id){
        Optional<Member> foundmember = members.stream().filter(member -> member.getId().equals(id)).findFirst();
        return foundmember;
    }

    public void addmember(Member member){
        members.add(member);
    }

    public void updatemember(Member updated, Long id){
        int n = members.size();
        for(int i=0;i<n;i++){
            Member member = members.get(i);
            if(member.getId().equals(id)){
                members.set(i, updated);
            }
        }
    }

    public void deletememberById(Long id){
        members.removeIf(member -> member.getId().equals(id));
    }
}