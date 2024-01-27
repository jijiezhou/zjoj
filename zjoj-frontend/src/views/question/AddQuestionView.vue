<template>
  <div id="addQuestionView">
    <h2>Add Question</h2>
    <a-form :model="form" label-align="left">
      <a-form-item field="title" label="Title">
        <a-input v-model="form.title" placeholder="please enter title" />
      </a-form-item>
      <a-form-item field="tags" label="Tags">
        <a-input-tag
          v-model="form.tags"
          placeholder="please pick labels"
          allow-clear
        />
      </a-form-item>
      <a-form-item field="content" label="Content">
        <MdEditor :value="form.content" :handle-change="onContentChange" />
      </a-form-item>
      <a-form-item field="answer" label="Answer">
        <MdEditor :value="form.answer" :handle-change="onAnswerChange" />
      </a-form-item>
      <a-form-item
        label="judgeConfiguration"
        :content-flex="false"
        :merge-props="false"
      >
        <a-space direction="vertical" style="min-width: 480px">
          <a-form-item field="judgeConfig.timeLimit" label="TimeLimit">
            <a-input-number
              v-model="form.judgeConfig.timeLimit"
              placeholder="please enter time limit"
              mode="button"
              min="0"
              size="large"
            />
          </a-form-item>
          <a-form-item field="judgeConfig.memoryLimit" label="MemoryLimit">
            <a-input-number
              v-model="form.judgeConfig.memoryLimit"
              placeholder="please enter memory limit"
              mode="button"
              min="0"
              size="large"
            />
          </a-form-item>
          <a-form-item field="judgeConfig.stackLimit" label="StackLimit">
            <a-input-number
              v-model="form.judgeConfig.stackLimit"
              placeholder="please enter stack limit"
              mode="button"
              min="0"
              size="large"
            />
          </a-form-item>
        </a-space>
      </a-form-item>
      <a-form-item label="judgeCase" :content-flex="false" :merge-props="false">
        <a-form-item
          v-for="(judgeCaseItem, index) of form.judgeCase"
          :key="index"
          no-style
        >
          <a-space direction="vertical" style="min-width: 640px">
            <a-form-item
              :field="`form.judgeCase[${index}].input`"
              :label="`inputCase-${index}`"
              :key="index"
            >
              <a-input
                v-model="judgeCaseItem.input"
                placeholder="please enter user input case"
              />
            </a-form-item>
            <a-form-item
              :field="`form.judgeCase[${index}].output`"
              :label="`outputCase-${index}`"
              :key="index"
            >
              <a-input
                v-model="judgeCaseItem.output"
                placeholder="please enter user output case"
              />
            </a-form-item>
            <a-button status="danger" @click="handleDelete(index)">
              Delete
            </a-button>
          </a-space>
        </a-form-item>
        <div style="margin-top: 32px">
          <a-button @click="handleAdd" type="outline" status="success"
            >Add Judge Case
          </a-button>
        </div>
      </a-form-item>
      <div style="margin-top: 16px" />
      <a-form-item>
        <a-button type="primary" style="min-width: 200px" @click="doSubmit"
          >Submit
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import MdEditor from "@/components/MdEditor.vue";
import { QuestionControllerService } from "../../../generated";
import message from "@arco-design/web-vue/es/message";

let form = ref({
  title: "",
  tags: [],
  answer: "",
  content: "",
  judgeConfig: {
    timeLimit: 1000,
    memoryLimit: 1000,
    stackLimit: 1000,
  },
  judgeCase: [
    {
      input: "",
      output: "",
    },
  ],
});

const onContentChange = (value: string) => {
  form.value.content = value;
};

const onAnswerChange = (value: string) => {
  form.value.answer = value;
};

/**
 * Add judgeCase
 */
const handleAdd = () => {
  form.value.judgeCase.push({
    input: "",
    output: "",
  });
};

/**
 * Delete judgeCase
 * @param index
 */
const handleDelete = (index: number) => {
  form.value.judgeCase.splice(index, 1);
};

/**
 * submit form
 */
const doSubmit = async () => {
  console.log(form.value);
  const res = await QuestionControllerService.addQuestionUsingPost(form.value);
  if (res.code === 0) {
    message.success("add question success");
  } else {
    message.error("add question fail, " + res.message);
  }
};
</script>

<style scoped>
#addQuestionView {
}
</style>
