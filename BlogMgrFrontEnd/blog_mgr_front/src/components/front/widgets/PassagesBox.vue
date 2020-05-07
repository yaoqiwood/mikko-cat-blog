<template>
  <div>
    <Row type="flex">
      <Col :xs="{span:24,offset:0,order:2}" :sm={span:20,offset:2,order:2} :md={span:12,offset:2,order:1}>
        <div class="passages-box"></div>
      </Col>
      <Col :xs="{span:24,offset:0,order:1}" :sm="{span:20,offset:2,order:1}" :md="{span:7,offset:1,order:2}">
        <div class="my-inf-frame-outer">
          <div class="my-inf-frame"/>
          <div class="my-inf-frame-inner-head-img"/>
          <span class="my-inf-frame-inner-span">一个想写前端的后端工程师</span>
        </div>
      </Col>
    </Row>
  </div>
</template>

<script>
export default {
  name: 'PassageBox'
}
</script>

<style lang="less" scoped>
  .passages-box {
    height: 50px;
    background-color: blue;
    /*margin-left: 30px;*/
    margin-top: 20px;
  }

  .my-inf-frame-outer {
    height: 190px;
    border-radius: 10px;
    overflow: hidden;
    margin-top: 20px;
    background-color: white;
    text-align: center;
    /*display: flex;*/
    /*justify-content: center;*/
  }

  .my-inf-frame {
    position: relative;
    background-image: url("../../../assets/front-img/MyInfFrameImg.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    height: 100px;
  }

  .my-inf-frame-inner-head-img {
    width: 70px;
    height: 70px;
    background-image: url("../../../assets/front-img/HeadImg.jpg");
    background-size: cover;
    margin: 0 auto;
    position: relative;
    top: -35px;
    border-radius: 50px;
    border: 2px solid white;
  }

  .my-inf-frame-inner-span {
    font-size: 13px;
    color: #5b6270;
    position: relative;
    top: -20px
  }
</style>
