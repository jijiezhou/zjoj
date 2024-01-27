<template>
  <div id="manageQuestionView">
    <h2>Manage Question</h2>
    <a-table
      :ref="tableRef"
      :columns="columns"
      :data="dataList"
      :pagination="{
        showTotal: true,
        pageSize: searchParams.pageSize,
        current: searchParams.pageNum,
        total,
      }"
    >
      <template #optional="{ record }">
        <a-space>
          <a-button type="primary" @click="doUpdate(record)">Edit</a-button>
          <a-button status="danger" @click="doDelete(record)">Delete</a-button>
        </a-space>
      </template>
    </a-table>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from "vue";
import { Question, QuestionControllerService } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";

const show = ref(true);

const tableRef = ref();
const dataList = ref([]);
const searchParams = ref({
  pageSize: 10,
  pageNum: 1,
});
const total = ref(0);

const loadData = async () => {
  const res = await QuestionControllerService.listQuestionByPageUsingPost(
    searchParams.value
  );
  if (res.code === 0) {
    dataList.value = res.data.records;
    total.value = res.data.total;
  } else {
    message.error("load fails" + res.message);
  }
};

/**
 * when page loaded -> loadData
 */
onMounted(() => {
  loadData();
});

const columns = [
  {
    title: "id",
    dataIndex: "id",
  },
  {
    title: "title",
    dataIndex: "title",
  },
  {
    title: "content",
    dataIndex: "content",
  },
  {
    title: "tags",
    dataIndex: "tags",
  },
  {
    title: "answer",
    dataIndex: "answer",
  },
  {
    title: "submitNum",
    dataIndex: "submitNum",
  },
  {
    title: "acceptedNum",
    dataIndex: "acceptedNum",
  },
  {
    title: "userId",
    dataIndex: "userId",
  },
  {
    title: "createTime",
    dataIndex: "createTime",
  },
  {
    title: "judgeConfig",
    dataIndex: "judgeConfig",
  },
  {
    title: "judgeCase",
    dataIndex: "judgeCase",
  },
  {
    title: "Operation",
    slotName: "optional",
  },
];

const doDelete = async (question: Question) => {
  const res = await QuestionControllerService.deleteQuestionUsingPost({
    id: question.id,
  });
  if (res.code === 0) {
    message.success("Delete Success");
    loadData();
  } else {
    message.error("Delete Fail" + res.message);
  }
};

const router = useRouter();

const doUpdate = (question: Question) => {
  router.push({
    path: "/update/question",
    query: {
      id: question.id,
    },
  });
};
</script>

<style scoped>
#manageQuestionView {
}
</style>
