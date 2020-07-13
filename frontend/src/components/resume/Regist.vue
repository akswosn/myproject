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
                    <div class="item row">
                        <div class="col-md-4 row">
                            <div class="col-5">
                                <input class="resume_input" type="text" name="" id="" placeholder="XXXX.XX">
                            </div>
                            <div class="col-2">
                             - 
                            </div>
                            <div class="col-5">
                                <input class="resume_input" type="text" name="" id="" placeholder="XXXX.XX">
                            </div>

                            <span class="title"><input class="resume_input" type="text" name="" id="" placeholder="(주)XXXXX"></span>
                        </div>
                        <div class="col-md-8">
                            <span class="title text-primary">업무 및 성과</span>
                            <span><textarea class="resume_input" placeholder="주요성과"></textarea></span>
                        </div>
                    </div>
                </div>
                <a class="add-item">+추가</a>
            </div>

            <div class="resume-body educate">
                <div class="body-header">
                    <span>학력</span>
                </div>
                <div class="body-content">
                    <div class="item row">
                        <div class="col-md-4 row">
                            <span class="col-5"><input type="text" class="resume_input" name="" id="" placeholder="XXXX.XX"> </span>
                            <span class="col-2">-  </span>
                            <span class="col-5"><input class="resume_input" type="text" name="" id="" placeholder="XXXX.XX"> </span>
                            
                        </div>
                        <div class="col-md-8 row" >
                            <span class="col-4"><input class="resume_input" type="text" name="" id="" placeholder="XXX학교"></span>
                            <span class="col-4"><input class="resume_input" type="text" name="" id="" placeholder="XXX과"></span>
                            <span class="col-1 "> 학점</span>
                            <span class="col-1"><input class="resume_input" type="text" name="" id="" ></span>
                            <span class="inline">/</span>
                            <span class="col-1"><input class="resume_input" type="text" name="" id="" ></span>
                        </div>
                        
                        
                    </div>
                </div>
                <a class="add-item">+추가</a>
            </div>

            <div class="resume-body certify">
                <div class="body-header">
                    자격증
                </div>
                <div class="body-content">
                    <div class="item row">
                        <span class="col-2"><input class="resume_input" type="text" name="" id="" placeholder="XXXX.XX"></span>
                        <span class="col-6"><input class="resume_input" type="text" name="" id="" placeholder="XXXXX자격증"></span>
                        <span class="col-4"><input class="resume_input" type="text" name="" id="" placeholder="XXX기관"></span>
                    </div>
                </div>
                <a class="add-item">+추가</a>
            </div>

            <div class="resume-body others">
                <div class="body-header">
                    수상 및 기타
                </div>
                <div class="body-content">
                    <div class="item row">
                        <span class="col-2"><input class="resume_input" type="text" name="" id="" placeholder="XXXX.XX"> </span>
                        <span class="inline">- </span>
                        <span class="col-2"><input class="resume_input" type="text" name="" id="" placeholder="XXXX.XX"></span>
                        <span class="col-4"><input class="resume_input" type="text" name="" id="" ></span>
                        <span class="col-3"><input class="resume_input" type="text" name="" id=""></span>
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
textarea {
    text-decoration-style: none;
    width: 100%;
    height: 100px;

}

.add-item {
    color: #176fd8;
    background-color: transparent;
    border-bottom: 1px solid #f1f1f1;
}
</style>