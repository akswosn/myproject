<template>
    <section class="page-section">
        <div class="resume_wrap">
            <div class="header">
                <ul class="content">
                    <li class="title">
                        <input class="resume_input" type="text" name="" id="" placeholder="제목">
                    </li>
                    <li class="">
                        <input class="resume_input" type="text" name="" id="" placeholder="000-0000-0000">
                    </li>
                    <li>
                        <input class="resume_input" type="text" name="" id="" placeholder="xxxx@xxxx.com">
                    </li>
                    <li>
                        <input class="resume_input" type="text" name="" id="" placeholder="https://www.github/xxxxx">
                    </li>
                    <li>
                        <span>간단한 소개</span>
                        <textarea class="resume_input"></textarea>
                    </li>
                    <li>
                        <span>SKILL</span>
                        <textarea class="resume_input"></textarea>
                    </li>
                </ul>
            </div>
            <div class="resume-body career">
                <div class="body-header">
                    <span>경력</span>
                </div>
                <div class="body-content">
                    <div class="itme">
                        <input class="resume_input" type="text" name="" id=""> - <input class="resume_input" type="text" name="" id="">
                        <span><input class="resume_input" type="text" name="" id=""></span>
                        <div>업무 및 성과</div>
                        <div><textarea class="resume_input"></textarea></div>
                    </div>
                </div>
                <a class="add-item">+추가</a>
            </div>

            <div class="resume-body educate">
                <div class="body-header">
                    <span>학력</span>
                </div>
                <div class="body-content">
                    <div class="itme">
                        <input type="text" class="resume_input" name="" id=""> - <input class="resume_input" type="text" name="" id="">
                        <span><input class="resume_input" type="text" name="" id="">학교 <input class="resume_input" type="text" name="" id="">과</span>
                        <input class="resume_input" type="text" name="" id="">/<input class="resume_input" type="text" name="" id="">
                    </div>
                </div>
                <a class="add-item">+추가</a>
            </div>

            <div class="resume-body certify">
                <div class="body-header">
                    자격증
                </div>
                <div class="body-content">
                    <div class="itme">
                        <input class="resume_input" type="text" name="" id="">
                        <span><input class="resume_input" type="text" name="" id=""></span>
                        <input class="resume_input" type="text" name="" id="">
                    </div>
                </div>
                <a class="add-item">+추가</a>
            </div>

            <div class="resume-body others">
                <div class="body-header">
                    수상 및 기타
                </div>
                <div class="body-content">
                    <div class="itme">
                        <input class="resume_input" type="text" name="" id=""> - <input class="resume_input" type="text" name="" id="">
                        <span><input class="resume_input" type="text" name="" id=""></span>
                        <input class="resume_input" type="text" name="" id="">
                    </div>
                </div>
                <a class="add-item">+추가</a>
            </div>
            <div class="resume-footer">
                <a class="btn btn-primary btn-xl ">저장</a>
            </div>
        </div>
        
    </section>
</template>

<script>
export default {
    name: 'resume-regist',
    data() {
        return {
            id : ''
        }
    },
    methods: {

    },
    mounted(){
        console.log('id', this.id);
    }
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
ul ,li{
    list-style: none;
}

.add-item {
    color: #176fd8;
    background-color: transparent;
    border-bottom: 1px solid #f1f1f1;
}
</style>