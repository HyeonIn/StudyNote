# Vue.js

## 목차

1. [Vue.js](#Vue.js)
2. [Vue Instance & Vue Instance LifeCycle](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/VueInstance.md)
3. Template
   1. [보간법(Interpolation)](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/Interpolation.md)
   2. [디렉티브(Directive)](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/directive.md)
4. [Vue Instance 속성](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/vueInstanceAttr.md)
5. [Vue Event](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/vueEvent.md)
6. [CSS class binding](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/CSSB.md)
7. [form input binding](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/FIB.md)
8. [Component](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/component.md)
   1. [Component간 통신](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/componentTx.md)
9. [vueCLI](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/vueCLI.md)
10. [axios](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/axios.md)
11. [vueRouter](https://github.com/HyeonIn/StudyNote/blob/main/Front-End/VueJS/study/vueRouter.md)

### Vue.js

##### 개요

- Evan You에 의해서 만들어짐
- Vue 탄생은 Google에서 Angular로 개발하다가 가벼운 걸 만들어 보고 싶은 생각으로 시작한 **개인 프로젝트**
- 사용자 인터페이스를 만들기 위해 사용하는 오픈소스 Progressive Framework

##### 특징

- 접근성 (Approachable)
- 유연성 (Versatile)
- 고성능 (Performant)

##### MVVM Pattern

<img src="MVVM.PNG"><br>

- Model + View + ViewModel
- Mdoel
  - 순수 자바스크립트 객체
- View
  - 웹 페이지의 POM
- ViewModel
  - Vue의 역할
- 기존에는 자바스크립트로 view에 해당하는 DOM에 접근하거나 수정하기 위해 jQuery와 같은 library 이용
- Vue는 view와 Model을 연결하고 자동으로 바인딩하므로 양방향 통신을 가능하게 함

##### Vue.js 3.x

- 22년 3월 출시
- 컴포지션 API 출시
